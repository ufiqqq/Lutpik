package model;

import com.google.gson.reflect.TypeToken;

import Node.Queue;
import Node.Schedule;
import modelGSON.ModelGSON;

import java.util.ArrayList;

public class ModelQueue {
    private ArrayList<Node.Queue> queues;
    ModelGSON modelGSON;

    public ModelQueue(){
        modelGSON = new ModelGSON("src/database/queue.json");

        queues = modelGSON.readFromFile(new TypeToken<ArrayList<Queue>>() {
        }.getType());
        if (queues == null){
            this.queues = new ArrayList<>();
        }

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
//            System.out.println("\nShutting down. Saving data to JSON file...");
            modelGSON.writeToFile(queues);
        }));
    }

    public void addQueue(Node.Queue queue){
        this.queues.add(queue);
    }

}
