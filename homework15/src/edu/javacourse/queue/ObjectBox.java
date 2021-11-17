package edu.javacourse.queue;

public class ObjectBox {
    private Object object;
    private ObjectBox next;

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public ObjectBox getNext() {
        return next;
    }

    public void setNext(ObjectBox next) {
        this.next = next;
    }
}
