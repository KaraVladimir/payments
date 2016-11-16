package commands;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Kara_Vladimir.
 */
public interface Command {
    void execute(HttpServletRequest request,HttpServletResponse httpServletResponse);
}
