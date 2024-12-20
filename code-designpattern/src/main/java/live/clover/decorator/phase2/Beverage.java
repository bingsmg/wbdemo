package live.clover.decorator.phase2;

/**
 * @author weibb
 */
public class Beverage {
    protected String description = "Unknown Beverage";
    protected boolean milk;
    protected boolean soy;
    protected boolean mocha;
    protected boolean whip;

    public double cost() {
        double cost = 0.0;
        if (hasMilk()) cost += 0.1;
        if (hasSoy()) cost += 0.15;
        if (hasMocha()) cost += 0.2;
        if (hasWhip()) cost += 0.1;
        return cost;
    }

    public String getDescription() {
        return description;
    }

    public boolean hasMilk() { return milk; }
    public void setMilk(boolean milk) { this.milk = milk; }

    public boolean hasSoy() { return soy; }
    public void setSoy(boolean soy) { this.soy = soy; }

    public boolean hasMocha() { return mocha; }
    public void setMocha(boolean mocha) { this.mocha = mocha; }

    public boolean hasWhip() { return whip; }
    public void setWhip(boolean whip) { this.whip = whip; }
}

class HouseBlend extends Beverage {
    public HouseBlend() {
        description = "House Blend Coffee";
    }

    @Override
    public double cost() {
        return 0.89 + super.cost();
    }
}

class DarkRoast extends Beverage {
    public DarkRoast() {
        description = "Most Excellent Dark Roast";
    }

    @Override
    public double cost() {
        return 0.99 + super.cost();
    }
}

class Decaf extends Beverage {
    public Decaf() {
        description = "Decaf Coffee";
    }

    @Override
    public double cost() {
        return 1.05 + super.cost();
    }
}

class Espresso extends Beverage {
    public Espresso() {
        description = "Espresso";
    }

    @Override
    public double cost() {
        return 1.99 + super.cost();
    }
}