package object;

import static calc.ConstantsDefinitions.*;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Obj {
    //Has no rotational Energy at the moment

    /*Movement contains speed direction and position coordinates as
     a two point vector with origin (position) and destination (speed as coordinates)
     */
    VectorObject movement; //Relative to the Object, Origin Point is the actual position
    VectorObject acceleration; //Relative to the Object's movement Vector's Source
    VectorObject gravity; //Relative to the Object's movement Vector's Source
    VectorObject[] forces; //Relative to the Object's movement Vector's Source
    public String shape = new String(); //Square, Die, Circle, Cylinder, Sphere
    public BigDecimal volume, density, mass, momentum, not_movement_energy, movement_energy, total_energy;

    public Obj(PointObject origin, PointObject destination) {
        this.movement = new VectorObject(destination);
        this.movement.setSource(origin);
        this.gravity = new VectorObject(zero, zero, const_gravity_e, 'c');
        this.gravity.setSource(origin);

        this.acceleration = new VectorObject(new PointObject(zero, zero, zero, 'c'));
    }

    public VectorObject getMovement() {
        return this.movement;
    }

    public VectorObject getAcceleration() {
        return this.acceleration;
    }

    public VectorObject getGravity() {
        return this.gravity;
    }

    public VectorObject[] getForces() {
        return this.forces;
    }

    /**
     * Changes the position of every source field.
     *
     * @param po the position to change the sources to
     */
    public void setPosition(PointObject po) {
        this.movement.setSource(po);
        this.movement.setNewRelativeDestination(po);
        this.acceleration.setSource(po);
        this.acceleration.setNewRelativeDestination(po);
        this.gravity.setSource(po);
        this.gravity.setNewRelativeDestination(po);

        if (forces != null) {
            for (VectorObject force : forces) {
                if (force != null) {
                    force.setSource(this.movement.getSource());
                }
            }
        }

    }

    /**
     * Returns the saved Mass of this Object. If Mass has not been defined it is
     * first calculated.
     *
     * @return Mass of this Object
     */
    public BigDecimal getMass() {
        if (this.mass == null) {
            return this.mass = this.volume.multiply(this.density);
        } else {
            return this.mass;
        }
    }

    //ToDo
    /**
     * This method calculates the volume based on shape and density or based on
     * density and mass.
     *
     * @return Volume
     */
    public BigDecimal getVolume() {
        BigDecimal ret = negone;

        if (density != null && mass != null) {
            ret = mass.divide(density, const_calc_prec, RoundingMode.HALF_UP);
        }

        return ret;

    }

    /**
     * Returns the Momentum of this Object based on the mass and the actual
     * linear speed of this Object.
     *
     * @return Linear Momentum
     */
    public BigDecimal getMomentum() {
        return this.mass.multiply(this.movement.getLength());
    }

//ToDo
    /**
     * Returns the relative mass of this Object based on the Specific Relativity
     * Thory
     *
     * @return relative mass
     */
    public BigDecimal getRelativeMass() {
        return negone;
    }

    /**
     * Returns the Movement Energy of this bject. Does not consider
     *
     * @return Movement Energy
     */
    public BigDecimal getMovementEnergy() {
        //E=(1/2)*m*(v^2)
        //movement.getLength = speed of object
        return (this.mass.multiply(this.movement.getLength().pow(2))).divide(two);
    }

    /**
     * Returns the Zero-Movement Energy of this Object. Also sets the
     * Zero-Movement Energy value of this Object.
     *
     * @return Zero-Movement Energy
     */
    public BigDecimal getNotMovementEnergy() {
        //E=m*(c^2)
        not_movement_energy = this.mass.multiply(const_c.pow(2));
        return not_movement_energy;
    }

    /**
     * Returns the added Zero-Movement Energy and the Movement energy.
     *
     * @return total energy
     */
    public BigDecimal getTotalEnergy() {
        BigDecimal local_movement_energy;
        BigDecimal local_total_energy;

        local_movement_energy = getMovementEnergy();
        not_movement_energy = getNotMovementEnergy();

        local_total_energy = local_movement_energy.add(not_movement_energy);

        return local_total_energy;
    }

}
