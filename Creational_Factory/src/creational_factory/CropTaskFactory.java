package creational_factory;

public class CropTaskFactory {
   public static CropTaskExecutor getTaskExecutor(String taskType) {
        switch (taskType.toLowerCase()) {
            case "water":
                return new WaterTaskExecutor();
            case "fertilize":
            case "fertilizer": // Add this to handle common user input error
                return new FertilizeTaskExecutor();
            case "harvest":
                return new HarvestTaskExecutor();
            default:
                throw new IllegalArgumentException("Unknown task type: " + taskType + ". Please enter 'water', 'fertilize', or 'harvest'.");
        }
    }
}

