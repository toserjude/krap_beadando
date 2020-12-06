package uni.eszterhazy.krap.exceptions;

public class AutoNotFound extends Throwable {
    public AutoNotFound(String rendszam) {
        super(rendszam);
    }
}
