package org.keycloak.test.framework.server;

import io.github.pixee.security.HostValidator;
import io.github.pixee.security.Urls;
import org.keycloak.common.util.KeycloakUriBuilder;

import java.net.MalformedURLException;
import java.net.URL;

public class KeycloakUrls {

    private final String baseUrl;

    public KeycloakUrls(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public String getBase() {
        return baseUrl;
    }

    public URL getBaseUrl() {
        return toUrl(getBase());
    }

    public String getAdmin() {
        return baseUrl + "/admin";
    }

    public URL getAdminUrl() {
        return toUrl(getAdmin());
    }

    public KeycloakUriBuilder getAdminBuilder() {
        return toBuilder(getAdmin());
    }

    private URL toUrl(String url) {
        try {
            return Urls.create(url, Urls.HTTP_PROTOCOLS, HostValidator.DENY_COMMON_INFRASTRUCTURE_TARGETS);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    private KeycloakUriBuilder toBuilder(String url) {
        return KeycloakUriBuilder.fromUri(url);
    }

}
