package ru.sbt.test.refactoring;

public class Tractor implements Movable {

    private int[] position = new int[]{0, 0};
    int[] field = new int[]{5, 5}; // to-do move to another class?
    Orientation orientation = Orientation.NORTH;
    private int positionX;
    private int positionY;

    @Override
    public void move() {
        moveForwards();
    }

    public Tractor() {
        this(Orientation.NORTH);
    }

    public Tractor(Orientation orientation) {
        this.orientation = orientation;
    }

    public void apply(String command) {
        if (command == "F") {
            move(new MoveForwardCommand());
        } else if (command == "T") {
            turnClockwise();
        }
    }

    public void moveForwards() {
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

    public void move(Command command) {
        command.execute(this);
    }

}
