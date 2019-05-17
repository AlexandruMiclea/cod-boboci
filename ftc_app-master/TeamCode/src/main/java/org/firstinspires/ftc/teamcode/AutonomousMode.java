package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;


@Autonomous(name = "AutonomousMode", group = "Autonomous")

public class AutonomousMode extends RobotHardware {


    @Override
    public void runOpMode() {
        Initialise();
        waitForStart();

        /*gyro.calibrate();
        while (gyro.isCalibrating()) {
            idle();
        }*/

        while (opModeIsActive()) {
            // TEST
            // TODO testeaza diagonalele
            Rotire(90);
            Rotire(-90);
            Strafe(StrafeDirection.FORWARD,1);
            Strafe(StrafeDirection.BACKWARD,1);
            Strafe(StrafeDirection.LEFT,1);
            Strafe(StrafeDirection.RIGHT,1);
            Strafe(StrafeDirection.FORWARDLEFT,1);
            Strafe(StrafeDirection.FORWARDRIGHT,1);
            Strafe(StrafeDirection.BACKWARDLEFT,1);
            Strafe(StrafeDirection.BACKWARDRIGHT,1);
        }
    }

    private void Strafe(StrafeDirection Direction, int durata){
        if (Direction == StrafeDirection.FORWARD){
            FL.setPower(0.7);
            FR.setPower(0.7);
            BL.setPower(0.7);
            BR.setPower(0.7);
            sleep(durata * 1000);
        }else if (Direction == StrafeDirection.BACKWARD){
            FL.setPower(-0.7);
            FR.setPower(-0.7);
            BL.setPower(-0.7);
            BR.setPower(-0.7);
            sleep(durata * 1000);
        }else if (Direction == StrafeDirection.LEFT) {
            FL.setPower(-0.7);
            FR.setPower(0.7);
            BL.setPower(0.7);
            BR.setPower(-0.7);
            sleep(durata * 1000);
        }else if (Direction == StrafeDirection.RIGHT){
            FL.setPower(0.7);
            FR.setPower(-0.7);
            BL.setPower(-0.7);
            BR.setPower(0.7);
            sleep(durata * 1000);
        }else if (Direction == StrafeDirection.FORWARDLEFT) {
            FL.setPower(0.7);
            BR.setPower(0.7);
            sleep(durata * 1000);
        }else if (Direction == StrafeDirection.FORWARDRIGHT) {
            FR.setPower(0.7);
            BL.setPower(0.7);
            sleep(durata * 1000);
        }else if (Direction == StrafeDirection.BACKWARDLEFT){
            FR.setPower(-0.7);
            BL.setPower(-0.7);
            sleep(durata * 1000);
        }else if (Direction == StrafeDirection.BACKWARDRIGHT) {
            FL.setPower(-0.7);
            BR.setPower(-0.7);
            sleep(durata * 1000);
        }

       StopMotors();

    }

    private void Rotire(int unghi) {
        int currentPosition = gyro.getHeading();
        int endPosition = currentPosition + unghi;

        double fata = 0.5;
        double spate = -0.5;

        if (endPosition>360){
            endPosition -=360;
        } else if (endPosition  < 0) {
            endPosition += 360;
        }

        if (unghi>0) {
            while (gyro.getHeading() != endPosition){
                FL.setPower(spate);
                BR.setPower(spate);
                FR.setPower(fata);
                BL.setPower(fata);
            }
        } else {
            while (gyro.getHeading() != endPosition){
                FL.setPower(fata);
                BR.setPower(fata);
                FR.setPower(spate);
                BL.setPower(spate);
            }
        }
         StopMotors();
    }


}
