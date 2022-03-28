package com.techprimers;

import com.codahale.metrics.health.HealthCheck;
import com.techprimers.resources.HelloWorldResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class DropWizardExampleApplication extends Application<DropWizardExampleConfiguration> {

    public static void main(final String[] args) throws Exception {
        new DropWizardExampleApplication().run(args);
    }

    @Override
    public String getName() {
        return "DropWizard-Example";
    }

    @Override
    public void initialize(final Bootstrap<DropWizardExampleConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final DropWizardExampleConfiguration configuration,
                    final Environment environment) {

        environment.jersey().register(new HelloWorldResource());

        environment.healthChecks().register("techprimers", new HealthCheck() {
            @Override
            protected Result check() throws Exception {
                return Result.unhealthy("Not ready");
            }
        });
    }
}
