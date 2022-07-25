package io.gaia_app;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TerraformRegistryIT {

    @Test
    void listModules() {
        var terraformRegistryClient = new TerraformRegistryClient();
        var response = terraformRegistryClient.listModules();
        assertThat(response.modules()).hasSize(15);

        assertThat(response.modules()).contains(
                new TerraformRegistry.Module(
                        "GoogleCloudPlatform/lb-http/google/6.2.0",
                        "",
                        "GoogleCloudPlatform",
                        "lb-http",
                        "6.2.0",
                        "google",
                        "/images/providers/google-cloud.svg",
                        "Modular Global HTTP Load Balancer for GCE using forwarding rules.",
                        "https://github.com/GoogleCloudPlatform/terraform-google-lb-http",
                        "v6.2.0",
                        "2021-12-07T16:35:06.836759Z",
                        482856,
                        true
                )
        );
    }

    @Test
    void testListModules() {
    }

    @Test
    void searchModules() {
    }
}