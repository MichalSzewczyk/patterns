package com.patterns.solid;

/**
 * Created by Michał Szewczyk on 2017-04-11.
 * Every class should be responsible for one thing
 */
public class SingleResponsibility {
    //Breaking the rule:
    static class ShowUser {
        void printRepresentation() {
            fetchFromDatabase();
            performProcessing();
            //...
        }

        void fetchFromDatabase() {
            //...
        }

        void performProcessing() {
            //...
        }
    }

    //After refactor:
    static class ShowUserProperly {
        private DatabaseAccessService databaseAccessService;
        private DataProcessor dataProcessor;

        //Dependency injection via constructor:
        public ShowUserProperly(DatabaseAccessService databaseAccessService, DataProcessor dataProcessor) {
            this.databaseAccessService = databaseAccessService;
            this.dataProcessor = dataProcessor;
        }

        void printRepresentation() {
            databaseAccessService.fetchFromDatabase();
            dataProcessor.performProcessing();
            //...
        }


    }

    private interface DatabaseAccessService {
        void fetchFromDatabase();
    }

    private interface DataProcessor {
        void performProcessing();
    }
}
