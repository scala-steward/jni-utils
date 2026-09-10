#include "coursier_bootstrap_launcher_jniutils_BootstrapNativeApi.h"
#include "coursier_jniutils_DefaultNativeApi.h"

JNIEXPORT jstring JNICALL Java_coursier_bootstrap_launcher_jniutils_BootstrapNativeApi_terminalSizeNative
  (JNIEnv *env, jclass class) {
  return Java_coursier_jniutils_DefaultNativeApi_terminalSizeNative(env, class);
}

JNIEXPORT jstring JNICALL Java_coursier_bootstrap_launcher_jniutils_BootstrapNativeApi_enableAnsiOutputNative
  (JNIEnv *env, jclass class) {
  return Java_coursier_jniutils_DefaultNativeApi_enableAnsiOutputNative(env, class);
}

JNIEXPORT jstring JNICALL Java_coursier_bootstrap_launcher_jniutils_BootstrapNativeApi_GetUserEnvironmentVariableNative
  (JNIEnv *env, jclass class, jstring key) {
  return Java_coursier_jniutils_DefaultNativeApi_GetUserEnvironmentVariableNative(env, class, key);
}

JNIEXPORT jstring JNICALL Java_coursier_bootstrap_launcher_jniutils_BootstrapNativeApi_SetUserEnvironmentVariableNative
  (JNIEnv *env, jclass class, jstring key, jstring value) {
  return Java_coursier_jniutils_DefaultNativeApi_SetUserEnvironmentVariableNative(env, class, key, value);
}

JNIEXPORT jstring JNICALL Java_coursier_bootstrap_launcher_jniutils_BootstrapNativeApi_DeleteUserEnvironmentVariableNative
  (JNIEnv *env, jclass class, jstring key) {
  return Java_coursier_jniutils_DefaultNativeApi_DeleteUserEnvironmentVariableNative(env, class, key);
}

JNIEXPORT jstring JNICALL Java_coursier_bootstrap_launcher_jniutils_BootstrapNativeApi_GetKnownFolderPathNative
  (JNIEnv *env, jclass class, jstring rfid) {
  return Java_coursier_jniutils_DefaultNativeApi_GetKnownFolderPathNative(env, class, rfid);
}

JNIEXPORT jstring JNICALL Java_coursier_bootstrap_launcher_jniutils_BootstrapNativeApi_GetModuleFileNameNative
  (JNIEnv *env, jclass class) {
  return Java_coursier_jniutils_DefaultNativeApi_GetModuleFileNameNative(env, class);
}

JNIEXPORT jint JNICALL Java_coursier_bootstrap_launcher_jniutils_BootstrapNativeApi_GetOEMCodePageNative
  (JNIEnv *env, jclass class) {
  return Java_coursier_jniutils_DefaultNativeApi_GetOEMCodePageNative(env, class);
}
