package com.irmandade.mutants.controllers;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.irmandade.mutants.controllers.MutantController;
import com.irmandade.mutants.services.HumanoService;
import com.irmandade.mutants.services.MutationService;

@RunWith(SpringRunner.class)
@WebMvcTest(MutantController.class)
public class MutantControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MutationService mutationService;
    
    @MockBean
    private HumanoService humanoService;

    @Test
    public void deveRetornarHttpStatusOk() throws Exception {
    	String dna = "[ \"AAAA\", \"AAAA\", \"AAAA\", \"AAAA\" ]";
        when(mutationService.isMutant(any())).thenReturn(true);
        this.mockMvc.perform(post("/mutants").contentType(
                MediaType.APPLICATION_JSON).content(dna)).andExpect(status().isOk());
    }
    
    @Test
    public void deveRetornarHttpStatusBadRequest() throws Exception {
    	String dna = "[ \"AAAA\", \"AAAA\" ]";
        when(mutationService.isMutant(any())).thenReturn(true);
        this.mockMvc.perform(post("/mutants").contentType(
                MediaType.APPLICATION_JSON).content(dna)).andExpect(status().isBadRequest());
    }

}