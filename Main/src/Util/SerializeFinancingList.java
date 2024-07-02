package Util;

import Model.Financing;
import java.io.*;
import java.util.ArrayList;

// ==== Class responsible for serializing and deserializing the financing list to a file ==== //
public class SerializeFinancingList {

     // Serialize the financing list to a file
    public static void serializeFinancingList(ArrayList<Financing> newFinancingList) {
        ArrayList<Financing> existingFinancingList = new ArrayList<>();
        File directory = new File("src/Data");
        if (!directory.exists()) {
            directory.mkdir(); // Create the directory if it doesn't exist
        }
        File file = new File(directory, "financingData.ser");

        if (file.exists()) {
            try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
                existingFinancingList = (ArrayList<Financing>) in.readObject();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        existingFinancingList.addAll(newFinancingList);

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file))) {
            out.writeObject(existingFinancingList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public static ArrayList<Financing> deserializeFinancingList() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("src/Data/financingData.ser"))) {
            return (ArrayList<Financing>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}