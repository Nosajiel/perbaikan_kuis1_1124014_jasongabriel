package src.model;

public interface Connectable {
    void connect(ConnectionType type);
    void disconnect();
}