import java.io.Serializable;

class StaticIDHandler implements Serializable {
    private int maxMenuID;
    private int maxSetID;
    private static StaticIDHandler instance = null;

    private StaticIDHandler() {
        this.maxMenuID = 1;
        this.maxSetID = 1;
    }

    public static StaticIDHandler getInstance() {
        if (instance == null)
            instance = new StaticIDHandler();
        return instance;
    }

    public void setInstance() {
        instance = this;
    }

    public int getMaxMenuID() {
        return this.maxMenuID;
    }

    public int getMaxSetID() {
        return this.maxSetID;
    }

    public void setMaxMenuID(int value) {
        this.maxMenuID = value;
    }

    public void setMaxSetID(int value) {
        this.maxSetID = value;
    }
}
