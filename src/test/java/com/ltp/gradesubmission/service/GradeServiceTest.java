package com.ltp.gradesubmission.service;

import com.ltp.gradesubmission.Constants;
import com.ltp.gradesubmission.pojo.Grade;
import com.ltp.gradesubmission.repository.GradeRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class GradeServiceTest {

    @Mock
    private GradeRepository gradeRepositoryMock;
    @InjectMocks
    private GradeService gradeService;

    @Test
    public void gradeIndexTest() {
        Grade grade = new Grade("Harry", "Potions", "C-");
        when(gradeRepositoryMock.getGrades()).thenReturn(Arrays.asList(grade));
        when(gradeRepositoryMock.getGrade(0)).thenReturn(grade);
        int valid =gradeService.getGradeIndex(grade.getId());
        int notFound = gradeService.getGradeIndex("123");

        assertEquals(0, valid);
        assertEquals(Constants.NOT_FOUND, notFound);
    }

    @Test
    public void returnGradeByIdTest() {
        Grade grade = new Grade("Harry", "Potions", "C-");
        when(gradeRepositoryMock.getGrades()).thenReturn(Arrays.asList(grade));
        when(gradeRepositoryMock.getGrade(0)).thenReturn(grade);

        String id = grade.getId();
        Grade result = gradeService.getGradeById(id);
        assertEquals(grade, result);
    }

}
