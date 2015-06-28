package ru.sbt.test.refactoring;

public class Tractor implements Movable {

    int[] field = new int[]{5, 5}; // to-do move to another class?
    Orientation orientation = Orientation.NORTH;
    private int positionX;
    private int positionY;

    public Tractor() {
        this(Orientation.NORTH);
    }

    public Tractor(Orientation orientation) {
        this.orientation = orientation;
    }

    public void apply(Command command) {
        command.execute(this);
    }

    public void apply(String command) {
        if ("F".equals(command)) {
            apply(new MoveForwardCommand());
        } else if ("T".equals(command)) {
            turnClockwise();
        }
    }

    @Override
    public void move() {
        if (orientation == Orientation.NORTH) {
            positionY = positionY + 1;
        } else if (orientation == Orientation.EAST) {
            positionX = positionX + 1;
        } else if (orientation == Orientation.SOUTH) {
            positionY = positionY - 1;
        } else if (orientation == Orientation.WEST) {
            positionX = positionX - 1;
        }
        if (positionX > field[0] || positionY > field[1]) {
            throw new TractorInDitchException();
        }
    }

    public void turnClockwise() {
        if (orientation == Orientation.NORTH) {
            orientation = Orientation.EAST;
        } else if (orientation == Orientation.EAST) {
            orientation = Orientation.SOUTH;
        } else if (orientation == Orientation.SOUTH) {
            orientation = Orientation.WEST;
        } else if (orientation == Orientation.WEST) {
            orientation = Orientation.NORTH;
        }
    }

    public int getPositionX() {
        return positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public Orientation getOrientation() {
        return orientation;
    }

}
