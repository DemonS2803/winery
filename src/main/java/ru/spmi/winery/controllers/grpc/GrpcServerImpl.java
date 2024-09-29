package ru.spmi.winery.controllers.grpc;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import ru.spmi.winery.controllers.grpc.greet.GreetServiceImpl;

import java.io.IOException;

//@Component
public class GrpcServerImpl {

    private static final Logger log = LoggerFactory.getLogger(GrpcServerImpl.class);

//    @Bean
//    public static void grpcServerStart() throws IOException, InterruptedException {
//        final int PORT = 9993;
//
//        // Create a new server to listen on port 9993
//        Server server = ServerBuilder.forPort(PORT)
//                .addService(new GreetServiceImpl())
//                .build();
//
//        // Start the server
//        server.start();
//
//        // Server threads are running in the background.
//        log.info("gRPC Server started, listening on " + PORT);
//        // Don't exit the main thread. Wait until server is terminated.
//        server.awaitTermination();
//    }

}
