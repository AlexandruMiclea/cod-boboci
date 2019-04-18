package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cGyro;
import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cRangeSensor;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@Autonomous(name = "AutonomousMode", group = "Autonomous")

public class AutonomousMode extends LinearOpMode {

    //motoare
    private DcMotor FL = null;
    private DcMotor FR = null;
    private DcMotor BL = null;
    private DcMotor BR = null;
    /*private DcMotor glisare = null;
    private DcMotor rotire_perii = null;
    private DcMotor ridicare_perii = null;
    private DcMotor ridicare_cutie = null;*/

    //sensori
    /*private ColorSensor color_sensor = null;
    private ModernRoboticsI2cRangeSensor range_right = null;
    private ModernRoboticsI2cRangeSensor range_left = null;*/

    //gyro
    private ModernRoboticsI2cGyro gyro = null;

    @Override
    public void runOpMode() {
        Initialise();
        waitForStart();

        gyro.calibrate();
        while (gyro.isCalibrating()) {
            idle();
        }

        while (opModeIsActive()) {

        }
    }

    private void Initialise() {
        //mapare
        FL = hardwareMap.dcMotor.get("Motor Fata Stanga");
        BL = hardwareMap.dcMotor.get("Motor Spate Stanga");
        BR = hardwareMap.dcMotor.get("Motor Spate Dreapta");
        FR = hardwareMap.dcMotor.get("Motor Fata Dreapta");
       /*glisare = hardwareMap.dcMotor.get("glisare");
        rotire_perii = hardwareMap.dcMotor.get("rotire_perii");
        ridicare_perii = hardwareMap.dcMotor.get("ridicare_perii");
        ridicare_cutie = hardwareMap.dcMotor.get("ridicare_cutie");
        color_sensor = hardwareMap.colorSensor.get("color_sensor");
        range_left = (ModernRoboticsI2cRangeSensor) hardwareMap.i2cDevice.get("range_left");
        range_right = (ModernRoboticsI2cRangeSensor) hardwareMap.i2cDevice.get("range_right");*/
        gyro = (ModernRoboticsI2cGyro) hardwareMap.gyroSensor.get("gyro");

        //directie motoare
        FL.setDirection(DcMotorSimple.Direction.FORWARD);
        BL.setDirection(DcMotorSimple.Direction.FORWARD);
        FR.setDirection(DcMotorSimple.Direction.REVERSE);
        BR.setDirection(DcMotorSimple.Direction.REVERSE);
      /*  glisare.setDirection(DcMotorSimple.Direction.FORWARD);
        rotire_perii.setDirection(DcMotorSimple.Direction.FORWARD);
        ridicare_perii.setDirection(DcMotorSimple.Direction.FORWARD);
        ridicare_cutie.setDirection(DcMotorSimple.Direction.FORWARD);*/

        //setare mod
        FL.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        BL.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        FR.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        BR.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        /*glisare.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rotire_perii.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        ridicare_perii.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        ridicare_cutie.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);*/

        //setare motor in tensiune
        FL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        FR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        BL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        BR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
       /* glisare.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rotire_perii.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        ridicare_perii.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        ridicare_cutie.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);*/

        //setare putere
        FL.setPower(0);
        FR.setPower(0);
        BL.setPower(0);
        BR.setPower(0);
        /*glisare.setPower(0);
        rotire_perii.setPower(0);
        ridicare_perii.setPower(0);
        ridicare_cutie.setPower(0);*/

        //porneste LED de la senzor culoare
       // color_sensor.enableLed(true);

    }

    private void Rotire (int unghi) {
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

    private void StopMotors () {
        FL.setPower(0);
        FR.setPower(0);
        BL.setPower(0);
        BR.setPower(0);
    }

}
