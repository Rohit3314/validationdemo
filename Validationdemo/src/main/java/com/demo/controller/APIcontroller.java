package com.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.APIcredential;
import com.demo.repository.Apirepository;



@RestController
@RequestMapping("/secureapi")
public class APIcontroller 
{
@Autowired
Apirepository apirepo;

@ResponseBody
@GetMapping(value = {"/"})
public ResponseEntity<List<APIcredential>> getAPICredentailsAll()
{
return new ResponseEntity<List<APIcredential>>(apirepo.findAll(),HttpStatus.OK);
}


@ResponseBody
@RequestMapping(value = "/addcredentials", method = RequestMethod.POST)
public ResponseEntity<Void> createCredentials(@Valid @RequestBody APIcredential apiobj ,
BindingResult result)
{
if(!result.hasErrors())
{
apirepo.save(apiobj);
return new ResponseEntity<Void>(HttpStatus.CREATED);
}
else
{
return new ResponseEntity<Void>(HttpStatus.FORBIDDEN);
}
}
}





