package com.patterns.factory.method.pattern;

import com.patterns.factory.method.model.Car;
import com.patterns.factory.method.model.Vehicle;

/**
 * Created by Michał Szewczyk on 2017-04-11.
 *
 * When we aren't sure which implementation of Vehicle we want to use,
 * we can use factory method instead creating objects directly. In case
 * of decision to change the implementation we can basically change it in
 * factory. In case of creating objects directly we would have to change every
 * place where object is created. What is more this design pattern forces relaying
 * on interfaces instead implementations which is a good practise according to SOLID
 * (Dependency inversion principle)
 */
public class VehicleFactoryMethod {
    public Vehicle getVehicle(){
        return new Car();
    }
}
