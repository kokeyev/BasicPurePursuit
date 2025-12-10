package org.firstinspires.ftc.teamcode.Okay;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.robotcore.external.navigation.Pose2D;
import org.firstinspires.ftc.teamcode.TestMotors;

public class FollowLine {

    private final Robot robot;
    private final Localizer localizer;


    private final double targetX;
    private final double targetY;
    private final double startX;
    private final double startY;
    private Telemetry telemetry;

    private final double dx, dy, totalDist;

    public FollowLine(Robot robot, Localizer localizer, double tx, double ty, Telemetry telemetry) {
        this.robot = robot;
        this.localizer = localizer;
        this.telemetry = telemetry;

        targetX = tx;
        targetY = ty;

        startX = localizer.odo.getPosX();
        startY = localizer.odo.getPosY();

        dx = targetX - startX;
        dy = targetY - startY;

        totalDist = Math.sqrt(dx*dx + dy*dy);
    }

    public double speedControl(double ratio, double maxSpeed) {

        // Clamp ratio to [0, 1]
        if (ratio < 0.0) ratio = 0.0;
        if (ratio > 1.0) ratio = 1.0;

        double speed = 0.0;
        double min_speed = 0.1;

        // First 30% — accelerate
        if (ratio < 0.3) {
            double k = (maxSpeed - min_speed) / 0.3;
            speed = k * ratio + min_speed;
        }
        // Middle 40% — constant max speed
        else if (ratio < 0.7) {
            speed = maxSpeed;
        }
        // Last 30% — decelerate
        else {
            // linear ramp from maxSpeed → 0
            double k = (min_speed - maxSpeed) / 0.3;
            double b = min_speed - k;
            speed = k * ratio + b;
        }

        return 0.1;
    }

    public boolean update() {



        return false; // continue
    }

    public void line_circle_intersection() {
        this.localizer.odo
    }

}