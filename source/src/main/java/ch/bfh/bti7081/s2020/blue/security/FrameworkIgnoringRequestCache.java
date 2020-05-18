package ch.bfh.bti7081.s2020.blue.security;

import ch.bfh.bti7081.s2020.blue.util.SecurityUtils;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;

/**
 * HttpSessionRequestCache that avoids saving internal framework requests.
 */
class FrameworkIgnoringRequestCache extends HttpSessionRequestCache {

  /**
   * {@inheritDoc}
   * <p>
   * If the method is considered an internal request from the framework, we skip saving it.
   *
   * @see SecurityUtils#isFrameworkInternalRequest(HttpServletRequest)
   */
  @Override
  public void saveRequest(HttpServletRequest request, HttpServletResponse response) {
    if (!SecurityUtils.isFrameworkInternalRequest(request)) {
      super.saveRequest(request, response);
    }
  }
}
