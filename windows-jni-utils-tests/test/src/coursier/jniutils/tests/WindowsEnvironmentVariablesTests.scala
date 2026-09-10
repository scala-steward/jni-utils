package coursier.jniutils.tests

import coursier.jniutils.WindowsEnvironmentVariables
import utest._

object WindowsEnvironmentVariablesTests extends TestSuite {

  private def cp(codePoint: Int): String = new String(Character.toChars(codePoint))

  // U+6E1D (CJK), U+00E9 (accented Latin) and U+1F389 (emoji, a surrogate pair in UTF-16).
  // None of them survives a trip through a code page that isn't UTF-8, which is what reading
  // and writing these values through the *A registry functions used to do. Built from code
  // points so that this file stays ASCII, and the test does not depend on the charset scalac
  // happens to read its sources with.
  private val nonAsciiValue = cp(0x6E1D) + " Jos" + cp(0xE9) + " " + cp(0x1F389)

  private def withTestKey[T](f: String => T): T = {
    val key = "COURSIER_JNIUTILS_TEST_" + java.util.UUID.randomUUID().toString.take(8)
    try f(key)
    finally WindowsEnvironmentVariables.delete(key)
  }

  private def roundTrip(): Unit =
    withTestKey { key =>
      WindowsEnvironmentVariables.set(key, nonAsciiValue)
      assert(WindowsEnvironmentVariables.get(key) == nonAsciiValue)
    }

  // Values with a '%' are stored as REG_EXPAND_SZ, and read back unexpanded.
  private def roundTripExpandable(): Unit =
    withTestKey { key =>
      val value = "%USERPROFILE%\\" + nonAsciiValue
      WindowsEnvironmentVariables.set(key, value)
      assert(WindowsEnvironmentVariables.get(key) == value)
    }

  val tests = Tests {
    test("default") synchronized {
      coursier.jniutils.NativeApi.set(null)
      roundTrip()
      roundTripExpandable()
    }

    test("bootstrap") synchronized {
      coursier.bootstrap.launcher.jniutils.BootstrapNativeApi.setup()
      roundTrip()
      roundTripExpandable()
    }

    test("lmcoursier") synchronized {
      lmcoursier.internal.jniutils.LmNativeApi.setup()
      roundTrip()
      roundTripExpandable()
    }

    test("coursierapi") synchronized {
      coursierapi.internal.jniutils.ApiInternalNativeApi.setup()
      roundTrip()
      roundTripExpandable()
    }

    test("missing key") synchronized {
      coursier.jniutils.NativeApi.set(null)
      withTestKey { key =>
        assert(WindowsEnvironmentVariables.get(key) == null)
      }
    }
  }
}
