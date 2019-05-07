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
            /*// TEST
            Rotire(90);
            Rotire(-90);*/
            Strafe(1,1);
            Strafe(2,1);
            Strafe(3,1);
            Strafe(4,1);
        }
    }

    private void Strafe(int directie, int durata){
        if (directie == 1){
            FL.setPower(0.7);
            FR.setPower(0.7);
            BL.setPower(0.7);
            BR.setPower(0.7);
            sleep(durata * 1000);
        }else if (directie == 2){
            FL.setPower(-0.7);
            FR.setPower(-0.7);
            BL.setPower(-0.7);
            BR.setPower(-0.7);
            sleep(durata * 1000);
        }else if (directie == 3) {
            FL.setPower(-0.7);
            FR.setPower(0.7);
            BL.setPower(0.7);
            BR.setPower(-0.7);
            sleep(durata * 1000);
        }else if (directie == 4){
            FL.setPower(0.7);
            FR.setPower(-0.7);
            BL.setPower(-0.7);
            BR.setPower(0.7);
            sleep(durata * 1000);
        } else {
            FL.setPower(0);
            FR.setPower(0);
            BL.setPower(0);
            BR.setPower(0);
        }
    }

    /*private void Rotire(int unghi) {
        int currentPosition = gyro.getHeading();
        int endPosition = currentPosition + unghi;

        double fata = 0.5;
        double spate = -0.5;

        if (endPosition>360){
            endPosition -=360;
        } else if (endPosition<0) {
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
    }*/

    private void StopMotors () {
        FL.setPower(0);
        FR.setPower(0);
        BL.setPower(0);
        BR.setPower(0);
    }

}
