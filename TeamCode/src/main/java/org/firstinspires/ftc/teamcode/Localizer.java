package org.firstinspires.ftc.teamcode;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.teamcode.GoBildaPinpointDriver;

public class Localizer {

    private final Robot robot;
    public final GoBildaPinpointDriver odo;

    private static final double TICKS_PER_MM = 19.89436789;

    // Offsets of tracking wheels from robot center
    private final double offsetX_mm = 14;
    private final double offsetY_mm = 7;

    private double lastX_ticks = 0;
    private double lastY_ticks = 0;
    private double lastHeading = 0;

    public Localizer(Robot robot, GoBildaPinpointDriver odo, double Xoffset, double Yoffset) {
        this.robot = robot;
        this.odo = odo;
        this.odo.setOffsets(Xoffset, Yoffset);
        this.odo.resetPosAndIMU();
        this.odo.setEncoderDirections(GoBildaPinpointDriver.EncoderDirection.REVERSED, GoBildaPinpointDriver.EncoderDirection.REVERSED);
        this.odo.update();
    }

    public void update() {
        odo.update();
    }
}