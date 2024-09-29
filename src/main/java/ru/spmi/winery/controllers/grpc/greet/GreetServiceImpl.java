package ru.spmi.winery.controllers.grpc.greet;

import io.grpc.stub.StreamObserver;

public class GreetServiceImpl extends GreetServiceGrpc.GreetServiceImplBase {

    @Override
    public void greet(GreetRequest request, StreamObserver<GreetResponse> responseObserver) {
        System.out.println("Greeting request: " + request);

        GreetResponse response = GreetResponse.newBuilder()
                .setResult("Some Response Value")
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

}
