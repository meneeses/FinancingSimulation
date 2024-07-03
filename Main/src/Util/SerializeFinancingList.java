package Util;

import Model.Financing;
import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

// ==== Class responsible for serializing and deserializing the financing list to a file ==== //
public class SerializeFinancingList {

     // Serialize the financing list to a file
     public static void serializeFinancingList(ArrayList<Financing> newFinancingList) {
         Set<Financing> financingSet = new HashSet<>();
         File file = new File("financingData.ser");

         // Deserialize the financing list from the file
         if (file.exists()) {
             try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
                 financingSet.addAll((ArrayList<Financing>) in.readObject());
             } catch (IOException | ClassNotFoundException e) {
                 e.printStackTrace();
             }
         }

         // Add the new financing list to the existing financing set
         financingSet.addAll(newFinancingList);

         // Serialize the financing set to the file
         try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file))) {
             out.writeObject(new ArrayList<>(financingSet));
         } catch (IOException e) {
             e.printStackTrace();
         }
     }

    @SuppressWarnings("unchecked")
    public static ArrayList<Financing> deserializeFinancingList() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("financingData.ser"))) {
            return (ArrayList<Financing>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}