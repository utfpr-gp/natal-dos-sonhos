package br.edu.utfpr.bean;

import br.edu.utfpr.model.School;
import br.edu.utfpr.model.service.SchoolService;
import br.edu.utfpr.util.MessageUtil;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Nadin on 05/12/16.
 */
@ManagedBean
@SessionScoped
public class SchoolBean implements Serializable{
    private List<School> schoolList;
    private School school;
    private SchoolService schoolService;

    @PostConstruct
    public void init() {
        schoolService = new SchoolService();
        schoolList = schoolService.findAll();
        school = new School();
    }

    public void persist() {
        if (school.getId() == null) {
            boolean isSucess = schoolService.save(school);
            if (isSucess) {
                this.schoolList.add(school);
                MessageUtil.showMessage("O dado foi inserido com sucesso!", "A escola " + school.getName() + " foi inserida", FacesMessage.SEVERITY_INFO);
            } else
                MessageUtil.showMessage("Oppsss! Ocorreu um erro ao salvar a escola", "A escola " + school.getName() + " não foi inserida", FacesMessage.SEVERITY_ERROR);
        } else
            if (schoolService.update(school))
                MessageUtil.showMessage("Atualização ocorreu com sucesso", "", FacesMessage.SEVERITY_INFO);
        this.school = new School();
    }

    public void edit(School school) {
        this.school = school;
    }

    public void delete(School school) {
        if (schoolService.delete(school)) {
            if(this.schoolList.remove(school))
                System.out.println("Removido da lista");
            MessageUtil.showMessage("Removido com sucesso", "", FacesMessage.SEVERITY_INFO);
        }
        else
            MessageUtil.showMessage("Falha ao remover", "", FacesMessage.SEVERITY_ERROR);
        this.school = new School();
    }

    public List<School> getSchoolList() {
        return schoolList;
    }

    public void setSchoolList(List<School> schoolList) {
        this.schoolList = schoolList;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public SchoolService getSchoolService() {
        return schoolService;
    }

    public void setSchoolService(SchoolService schoolService) {
        this.schoolService = schoolService;
    }
}
