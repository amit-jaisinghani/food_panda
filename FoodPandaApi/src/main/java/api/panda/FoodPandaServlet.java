package api.panda;

import fp.bean.Context;
import fp.bean.ThreadContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class FoodPandaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long startTime = System.currentTimeMillis();
        initiateContent(req, resp);
        generateGetResponse();
        System.out.println("Request time: " + (System.currentTimeMillis() - startTime));
    }

    private void generateGetResponse() {
        writeAndFlushResponse("Unique request id: " + ThreadContext.getThreadLocalContext().getUuid());
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doDelete(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    private void initiateContent(HttpServletRequest req, HttpServletResponse resp){
        ThreadContext.setThreadLocalContext(new Context(req, resp));
    }

    public void writeAndFlushResponse(String response) {
        try (PrintWriter writer = ThreadContext.getThreadLocalContext()
                .getHttpServletResponse().getWriter()) {
            writer.write(response);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
