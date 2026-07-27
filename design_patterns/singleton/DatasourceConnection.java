package design_patterns.singleton;

public class DatasourceConnection {
    private static DatasourceConnection instance;

    private DatasourceConnection(){

    }

    public static DatasourceConnection getInstance(){ // it should be static,
        //if its instance then client cant create object as ours private
        if(instance==null){
            instance = new DatasourceConnection();
        }
        return instance;
    }

    public static void main(String[] args) {
        DatasourceConnection connection1 = DatasourceConnection.getInstance();
        DatasourceConnection connection2 = DatasourceConnection.getInstance();
        System.out.println(connection2==connection1);
    }
}
