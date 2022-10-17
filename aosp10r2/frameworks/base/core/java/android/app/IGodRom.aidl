package android.app;
// change godrom
interface IGodRom
{
    String readFile(String path);
    void writeFile(String path,String data);
    String shellExec(String cmd);
}