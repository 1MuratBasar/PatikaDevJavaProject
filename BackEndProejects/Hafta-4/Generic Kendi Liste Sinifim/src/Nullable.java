public class Nullable <T>{ //generic

    private final T value;

    public Nullable (T value){
        this.value = value;
    }

    public T getValue() {
        return this.value;
    }
}
