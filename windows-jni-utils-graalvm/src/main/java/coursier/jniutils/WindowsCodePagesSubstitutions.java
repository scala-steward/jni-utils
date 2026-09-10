package coursier.jniutils;

import com.oracle.svm.core.annotate.Substitute;
import com.oracle.svm.core.annotate.TargetClass;
import org.graalvm.nativeimage.Platform;
import org.graalvm.nativeimage.Platforms;

@TargetClass(className = "coursier.jniutils.WindowsCodePages")
@Platforms({Platform.DARWIN.class, Platform.LINUX.class})
final class WindowsCodePagesSubstitutions {

    @Substitute
    public static int oem() {
        throw new RuntimeException("Not available on this platform");
    }

}
