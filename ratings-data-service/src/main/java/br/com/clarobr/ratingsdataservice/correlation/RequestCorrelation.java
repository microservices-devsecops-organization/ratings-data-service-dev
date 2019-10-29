package br.com.clarobr.ratingsdataservice.correlation;

public class RequestCorrelation {

	public static final String CORRELATION_ID_HEADER = "X-Correlation-Id";

	private static String correlationId;

	private static final ThreadLocal<String> id = new ThreadLocal<String>();

    public static String getCorrelationid() {
		return correlationId;
	}
    
    public static void setCorrelationid(String correlationid) {
		correlationId = correlationid;
	}

    public static void setId(String correlationId) {
        id.set(correlationId);
    }

    public static String getId() {
        return id.get();
    }
}
