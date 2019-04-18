package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.Range;

@TeleOp(name = "DriverMode", group = "Driver")

public class DriverMode extends LinearOpMode {

    private DcMotor FL = null;
    private DcMotor FR = null;
    private DcMotor BL = null;
    private DcMotor BR = null;
    private DcMotor extindere_perii = null;
    private DcMotor rotire_perii = null;
    private DcMotor cutie_perii = null;
    private DcMotor glisiera = null;

    private double deadzone = 0.1;

    @Override
    public void runOpMode() {
        Initialise();
        waitForStart();

        while (opModeIsActive()) {
            Gamepad1();
            //Gamepad2();
        }
    }

    protected void Initialise() {

        FL = hardwareMap.dcMotor.get("Motor Fata Stanga");
        BL = hardwareMap.dcMotor.get("Motor Spate Stanga");
        BR = hardwareMap.dcMotor.get("Motor Spate Dreapta");
        FR = hardwareMap.dcMotor.get("Motor Fata Dreapta");
     /*   extindere_perii = hardwareMap.dcMotor.get("glisare");
        rotire_perii = hardwareMap.dcMotor.get("rotire_perii");
        cutie_perii = hardwareMap.dcMotor.get("ridicare_perii");
        glisiera = hardwareMap.dcMotor.get("ridicare_cutie");*/

        FL.setDirection(DcMotorSimple.Direction.FORWARD);
        BL.setDirection(DcMotorSimple.Direction.FORWARD);
        FR.setDirection(DcMotorSimple.Direction.REVERSE);
        BR.setDirection(DcMotorSimple.Direction.REVERSE);
/*        extindere_perii.setDirection(DcMotorSimple.Direction.FORWARD);
        rotire_perii.setDirection(DcMotorSimple.Direction.FORWARD);
        cutie_perii.setDirection(DcMotorSimple.Direction.FORWARD);
        glisiera.setDirection(DcMotorSimple.Direction.FORWARD);*/

        FL.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        BL.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        FR.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        BR.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
   /*     extindere_perii.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rotire_perii.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        cutie_perii.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        glisiera.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);*/

        FL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        FR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        BL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        BR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
/*
        extindere_perii.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rotire_perii.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        cutie_perii.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        glisiera.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
*/

        FL.setPower(0);
        FR.setPower(0);
        BL.setPower(0);
        BR.setPower(0);
/*        extindere_perii.setPower(0);
        rotire_perii.setPower(0);
        cutie_perii.setPower(0);
        glisiera.setPower(0);*/

    }

    protected void Gamepad1() {
        // Joystick left
        if(Math.abs(gamepad1.left_stick_y) > deadzone){
            FL.setPower(Range.clip(gamepad1.left_stick_x, -0.9, 0.9));
            BL.setPower(Range.clip(gamepad1.left_stick_x, -0.9, 0.9));
        }
        else{
            FL.setPower(0);
            BL.setPower(0);
        }

        // Joystick right
        if(Math.abs(gamepad1.right_stick_y) > deadzone){
            FR.setPower(Range.clip(gamepad1.right_stick_x, -0.9, 0.9));
            BR.setPower(Range.clip(gamepad1.right_stick_x, -0.9, 0.9));
        }
        else{
            FR.setPower(0);
            BR.setPower(0);
        }

    }

/*    protected void Gamepad2() {
        if(gamepad2.x) rotire_perii.setPower(0.5);
        else if(gamepad2.y) rotire_perii.setPower(-0.5);
        else rotire_perii.setPower(0);

        if(gamepad2.a) cutie_perii.setPower(0.5);
        else if(gamepad2.b) cutie_perii.setPower(-0.5);
        else cutie_perii.setPower(0);
        
        *//*if(gamepad2.dpad_up) glisiera.setPower(0.5);
        else if(gamepad2.dpad_down)  glisiera.setPower(-0.5);
        else glisiera.setPower(0);*//*

        if(gamepad2.left_stick_y > deadzone) extindere_perii.setPower(Range.clip(gamepad2.left_stick_y, 0.1, 0.7));
        else if(gamepad2.left_stick_y < -deadzone) extindere_perii.setPower(Range.clip(gamepad2.left_stick_y, -0.5, -0.1));

        if(gamepad2.dpad_up) glisiera.setPower(0.5);
        else if(gamepad2.dpad_down)  glisiera.setPower(-0.5);
        else glisiera.setPower(0);

        if(gamepad2.left_stick_y > deadzone) extindere_perii.setPower(Range.clip(gamepad2.left_stick_y, 0.1, 0.7));
        else if(gamepad2.left_stick_y < -deadzone) extindere_perii.setPower(Range.clip(gamepad2.left_stick_y, -0.5, - 0.1));
        else extindere_perii.setPower(0);

    }*/
}
