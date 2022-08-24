Feature: Entrance Exam Functionality

  Background:
    Given Navigate to basqar
    When Enter username and password and click login button
    Then User should login successfuly

  Scenario Outline: Create and Delete an Exam

    And Click on the element in the left Nav
      | entranceExamsOne |
      | setupTwo         |
      | entranceExamsTwo |

    And Click on the element in the Dialog
      | addButton |

    And User sending the keys in Dialog content
      | nameInput | <ExamName> |

    And Click on the element in the Form Content
      | academicPeriod |
      | <AcademicPeriodOption> |
      | gradeLevel |
      | <GradeLevelOption> |

    And Click on the element in the Dialog
      | saveButton |

    Then Success message should be displayed

    And Click on the element in the left Nav
      | entranceExamsOne |
      | setupTwo         |
      | entranceExamsTwo |

    And User delete item from Dialog
      | <ExamName> |

    Then Success message should be displayed

    Examples:
      | ExamName    | AcademicPeriodOption | GradeLevelOption |
      | met exam 1  | academicPeriod1      | gradeLevel2      |
      | met exam 2  | academicPeriod1      | gradeLevel2      |
      | met exam 3  | academicPeriod1      | gradeLevel2      |
      | met exam 4  | academicPeriod1      | gradeLevel2      |

    #TODO yukarıdaki akademik ve Grade Level Option için academicPeriod2 ve gradeLevel1,3,4 bulunup example koyulacak.