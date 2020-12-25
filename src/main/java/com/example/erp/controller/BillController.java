package com.example.erp.controller;

import com.example.erp.bean.Bill;
import com.example.erp.bean.Student_payment;
import com.example.erp.bean.student;
import com.example.erp.services.BillsService;
import com.example.erp.services.LoginService;
import org.glassfish.jersey.media.multipart.FormDataParam;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Path("bills")
public class BillController
{
        @POST
        @Path("/add/{desc}/{amt}/{date}/{dead}/{id}")
        @Consumes(MediaType.MULTIPART_FORM_DATA)
        @Produces(MediaType.TEXT_HTML)
            public Response add_bill(@PathParam("desc") String descrption,
                    @PathParam("amt") int amount,@PathParam("date") String date,@PathParam("dead") String deadline ,@PathParam("id") int id) throws URISyntaxException {
            String result = "Added Bill";
            System.out.println(result);
            BillsService bls = new BillsService();
            student s = bls.getstudentbyid(id);
            bls.addBillToStudent(amount, date, deadline, descrption, s);

            System.out.println(result);
            return Response.status(200).entity(result).build();
        }

    @POST
    @Path("/addbilldept/{desc}/{amt}/{date}/{dead}/{department}")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.TEXT_HTML)
    public Response add_billdept(@PathParam("desc") String descrption,
                             @PathParam("amt") int amount,@PathParam("date") String date,@PathParam("dead") String deadline,@PathParam("department") String dept) throws URISyntaxException {

            BillsService bls = new BillsService();
            bls.addBillToDept(amount, date, deadline, descrption,dept);
            String result = "Added Bill to given department";
             return Response.status(200).entity(result).build();
    }

    @POST
    @Path("/update1/{id}/{amount}")
    @Produces(MediaType.TEXT_HTML)
    public Response update_bill(@PathParam("id") int billid,
                             @PathParam("amount") int amt) throws URISyntaxException {
        BillsService bls = new BillsService();
        bls.updateBill1(billid,amt);
        String result = "Updated Bill Amount";
        return Response.status(200).entity(result).build();

    }

    @POST
    @Path("/update2/{ids}/{date}")
    @Produces(MediaType.TEXT_HTML)
    public Response update2_bill(@PathParam("ids") int bid,
                             @PathParam("date") String deadline) throws URISyntaxException {
        BillsService bls = new BillsService();
        bls.updateBill2(bid,deadline);
        String result = "Updated Bill Date";
        return Response.status(200).entity(result).build();
    }

    @POST
    @Path("/deletebill/{bilid}")
    @Produces(MediaType.TEXT_HTML)
    public Response delete_bill(@PathParam("bilid") int idk
                             ) throws URISyntaxException {
        BillsService bls = new BillsService();
        bls.deleteBill(idk);
        String result = "Delete Bill";
        return Response.status(200).entity(result).build();
    }

    @GET
    @Path("/viewAllBills")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response viewAllBills(
    ) throws URISyntaxException
    {
        List<Student_payment> sp  = new ArrayList<>();
        BillsService bls = new BillsService();
        sp = bls.billPaidView();
        GenericEntity<List<Student_payment>> genericEntity = new GenericEntity<List<Student_payment>>(sp){};
        return Response.ok(genericEntity, MediaType.APPLICATION_JSON).build();
    }

    @GET
    @Path("/viewnotpaid_stu")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response view(
    ) throws URISyntaxException
    {
        Set<student> sp = new HashSet<>();
        BillsService bls = new BillsService();
        sp = bls.billNotPaidView_by_students();
        GenericEntity<Set<student>> genericEntity = new GenericEntity<Set<student>>(sp){};
        return Response.ok(genericEntity, MediaType.APPLICATION_JSON).build();
    }

    @GET
    @Path("/viewnotpaid_billid")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response viewBill_billid(
    ) throws URISyntaxException
    {
        Set<Bill> sp = new HashSet<>();
        BillsService bls = new BillsService();
        sp = bls.billNotPaidView_by_billid();
        GenericEntity<Set<Bill>> genericEntity = new GenericEntity<Set<Bill>>(sp){};
        return Response.ok(genericEntity, MediaType.APPLICATION_JSON).build();
    }


    // add view by id , not paid students , not paid bill id's





}
