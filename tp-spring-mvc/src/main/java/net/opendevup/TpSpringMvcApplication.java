package net.opendevup;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import net.opendevup.dao.EtudiantRepository;
import net.opendevup.entities.Etudiant;

@SpringBootApplication
public class TpSpringMvcApplication {

	public static void main(String[] args) throws ParseException {
		ApplicationContext ctx = SpringApplication.run(TpSpringMvcApplication.class, args);
		EtudiantRepository etudiantRepository = ctx.getBean(EtudiantRepository.class);
		DateFormat df = new SimpleDateFormat("YYYY-MM-DD");
		etudiantRepository.save(new Etudiant("Ali", df.parse("1999-12-15") , "ali@gmail.com", "ali.jpg"));
		etudiantRepository.save(new Etudiant("Said", df.parse("1989-07-19") , "said@live.com", "said.jpg"));
		etudiantRepository.save(new Etudiant("Bihi", df.parse("1992-06-25") , "bihi@frre.com", "bihi.jpg"));
		
		//Page<Etudiant> etds = etudiantRepository.findAll(new PageRequest(0,5));
		Page<Etudiant> etds = etudiantRepository.chercherEtudiants("%A%", new PageRequest(0,5));
		etds.forEach(e->System.out.println(e.getNom()));
		
	}
}
