package coursier.bootstrap.launcher.jniutils;

import coursier.jniutils.LoadWindowsLibrary;
import coursier.jniutils.NativeApi;

public final class BootstrapNativeApi extends NativeApi {

    static native String terminalSizeNative();

    static native String enableAnsiOutputNative();

    static native byte[] GetUserEnvironmentVariableNative(byte[] key);
    static native byte[] SetUserEnvironmentVariableNative(byte[] key, byte[] value);
    static native byte[] DeleteUserEnvironmentVariableNative(byte[] key);

    static native String GetKnownFolderPathNative(String rfid);


    public String terminalSize() {
        return terminalSizeNative();
    }

    public String enableAnsiOutput() {
        return enableAnsiOutputNative();
    }

    public byte[] GetUserEnvironmentVariable(byte[] key) {
        return GetUserEnvironmentVariableNative(key);
    }
    public byte[] SetUserEnvironmentVariable(byte[] key, byte[] value) {
        return SetUserEnvironmentVariableNative(key, value);
    }
    public byte[] DeleteUserEnvironmentVariable(byte[] key) {
        return DeleteUserEnvironmentVariableNative(key);
    }

    public String GetKnownFolderPath(String rfid) {
        return GetKnownFolderPathNative(rfid);
    }

    static {
        LoadWindowsLibrary.ensureInitialized();
    }

    public static void setup() {
        NativeApi.set(new BootstrapNativeApi());
    }
}
