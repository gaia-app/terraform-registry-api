package io.gaia_app;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public interface TerraformRegistry {

    record Module(String id, String owner, String namespace, String name, String version, String provider,
                  String provider_logo_url,
                  String description, String source, String tag, String published_at, long downloads, boolean verified) {
    }

    record Meta(long limit, long current_offset, long next_offset, String next_url) {
    }

    record PaginableResponse(Meta meta, List<Module> modules) {
    }

    /**
     * These endpoints list modules according to some criteria.
     * @return
     */
    PaginableResponse listModules();

    /**
     * These endpoints list modules according to some criteria.
     * @param namespace Restricts listing to modules published by this user or organization. This is optionally specified as part of the URL path.
     * @return
     */
    PaginableResponse listModules(String namespace);

    /**
     * This endpoint allows searching modules.
     * @param q The search string. Search syntax understood depends on registry implementation. The public registry supports basic keyword or phrase searches.
     * @return
     */
    PaginableResponse searchModules(String q);

}
