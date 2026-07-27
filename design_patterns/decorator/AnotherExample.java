package design_patterns.decorator;


/*
It uses composition instead of our inheritance,
drawback suppose in the decorator i m adding new method
then i need to copy and paste in the all the decorators, its duplication,
but with inheritance it automatically gets it

 */
interface DataSource {
    void writeData(String data);
    String readData();
}

class FileDataSource implements DataSource {
    private String filename;

    public FileDataSource(String filename) {
        this.filename = filename;
    }

    public void writeData(String data) {
        System.out.println("write from file source");
        // Write to file
    }

    public String readData() {
        System.out.println("read from file source");
        // Read from file
        return "data from file";
    }
}

class EncryptionDecorator implements DataSource {
    private DataSource wrapped;

    public EncryptionDecorator(DataSource source) {
        this.wrapped = source;
    }

    public void writeData(String data) {
        System.out.println("write data from encrypt");
        String encrypted = encrypt(data);
        wrapped.writeData(encrypted);  // Delegate to wrapped object
    }

    public String readData() {
        System.out.println("read data from encrypt");
        String data = wrapped.readData();
        return decrypt(data);
    }

    private String encrypt(String data) {
        System.out.println("encrypt  from encrypt");
        return "encrypted:" + data;
    }

    private String decrypt(String data) {
        System.out.println("decrypt from encrypt");
        return data.replace("encrypted:", "");
    }
}

class CompressionDecorator implements DataSource {
    private DataSource wrapped;

    public CompressionDecorator(DataSource source) {
        this.wrapped = source;
    }

    public void writeData(String data) {
        System.out.println("write data from compress");
        String compressed = compress(data);
        wrapped.writeData(compressed);  // Delegate to wrapped object
    }

    public String readData() {
        System.out.println("read data from compress");
        String data = wrapped.readData();
        return decompress(data);
    }

    private String compress(String data) {
        System.out.println("compressing");
        return "compressed:" + data;
    }

    private String decompress(String data) {
        System.out.println("decompressing");
        return data.replace("compressed:", "");
    }
}



public class AnotherExample {
    public static void main(String[] args) {
        // Usage
        DataSource source = new FileDataSource("data.txt");
        source = new EncryptionDecorator(source);
        source = new CompressionDecorator(source);
        source.writeData("sensitive info");
// Data gets compressed, then encrypted, then written to file


    }
}
