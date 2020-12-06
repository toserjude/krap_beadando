package uni.eszterhazy.krap.exceptions;

public class AutoAlreadyAdded extends Throwable {
    public AutoAlreadyAdded(String rendszam) {
        super(rendszam);
    }
}
