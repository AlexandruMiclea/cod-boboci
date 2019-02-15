package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

public class Driver_mode extends LinearOpMode {

    private DcMotor mers_left = null;
    private DcMotor mers_right = null;
    private DcMotor extindere_perii = null;
    private DcMotor rotire_perii = null;
    private DcMotor cutie_perii = null;
    private DcMotor glisiera = null;

    @Override
    public void runOpMode() {
        Initialise();
        waitForStart();
    }

    protected void Initialise() {

        mers_right = hardwareMap.dcMotor.get("mers_right");
        mers_left = hardwareMap.dcMotor.get("mers_left");
        extindere_perii = hardwareMap.dcMotor.get("extindere_perii");
        rotire_perii = hardwareMap.dcMotor.get("rotire_perii");
        cutie_perii = hardwareMap.dcMotor.get("cutie_perii");
        glisiera = hardwareMap.dcMotor.get("glisiera");

        mers_right.setDirection(DcMotorSimple.Direction.FORWARD);
        mers_left.setDirection(DcMotorSimple.Direction.FORWARD);
        extindere_perii.setDirection(DcMotorSimple.Direction.FORWARD);
        rotire_perii.setDirection(DcMotorSimple.Direction.FORWARD);
        cutie_perii.setDirection(DcMotorSimple.Direction.FORWARD);
        glisiera.setDirection(DcMotorSimple.Direction.FORWARD);

        mers_right.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        mers_left.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        extindere_perii.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rotire_perii.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        cutie_perii.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        glisiera.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        mers_right.setPower(0);
        mers_left.setPower(0);
        extindere_perii.setPower(0);
        rotire_perii.setPower(0);
        cutie_perii.setPower(0);
        glisiera.setPower(0);

    }

    protected void Gamepad1() {

    }

    protected void Gamepad2() {
        if(gamepad2.x) rotire_perii.setPower(0.5);
        else if(gamepad2.y) rotire_perii.setPower(-0.5);
        else rotire_perii.setPower(0);

        if(gamepad2.a)


    }
}
