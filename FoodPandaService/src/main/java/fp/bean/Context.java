package fp.bean;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.UUID;

public class Context {

    //ID
    private UUID uuid;

    //End Service Context
    private HttpServletRequest httpServletRequest;
    private HttpServletResponse httpServletResponse;
    private Map<String, String[]> parameterMap;

    public Context(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        this.httpServletRequest = httpServletRequest;
        this.httpServletResponse = httpServletResponse;
        this.parameterMap = httpServletRequest.getParameterMap();
        this.uuid = UUID.randomUUID();
    }

    public UUID getUuid() {
        return uuid;
    }

    public Map<String, String[]> getParameterMap() {
        return parameterMap;
    }
}
