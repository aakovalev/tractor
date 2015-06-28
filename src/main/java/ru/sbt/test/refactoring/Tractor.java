package ru.sbt.test.refactoring;

public class Tractor implements Positionable, Movable {

    int[] field = new int[]{5, 5}; // to-do move to another class?
    Orientation orientation = Orientation.NORTH;
    private Position position = new Position(0, 0);

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
            apply(new MoveForward());
        } else if ("T".equals(command)) {
            turnClockwise();
        }
    }

    @Override
    public void move() {
        if (orientation == Orientation.NORTH) {
            setPosition(new Position(position.getX(), position.getY() + 1));
        } else if (orientation == Orientation.EAST) {
            setPosition(new Position(position.getX() + 1, position.getY()));
        } else if (orientation == Orientation.SOUTH) {
            setPosition(new Position(position.getX(), position.getY() - 1));
        } else if (orientation == Orientation.WEST) {
            setPosition(new Position(position.getX() - 1, position.getY()));
        }
        if (position.getX() > field[0] || position.getY() > field[1]) {
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
        return position.getX();
    }

    public int getPositionY() {
        return position.getY();
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public void setPosition(Position newPosition) {
        this.position = newPosition;
    }

    public Position getPosition() {
        return position;
    }
}
