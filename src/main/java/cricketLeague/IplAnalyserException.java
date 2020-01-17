package cricketLeague;

public class IplAnalyserException extends Throwable {


    enum ExceptionType{
        FILE_LOAD_PROBLEM,NO_CENSUS_DATA;
    }

    ExceptionType type;

    public IplAnalyserException(String message, ExceptionType type) {
        super(message);
        this.type=type;
    }
    public IplAnalyserException(String message, String name) {
        this.type=ExceptionType.valueOf(name);
    }



}
