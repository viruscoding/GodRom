// IGodRom.aidl
package android.app;

// Declare any non-default types here with import statements

interface IGodRom {
        String shellExec(String cmd);
        String readFile(String path);
        void writeFile(String path,String data);
}