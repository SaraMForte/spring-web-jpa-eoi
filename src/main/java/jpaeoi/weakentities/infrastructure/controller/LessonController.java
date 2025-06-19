package jpaeoi.weakentities.infrastructure.controller;

import jpaeoi.weakentities.application.LessonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("weak-entities")
public class LessonController {

    LessonService lessonService;

    public LessonController(LessonService lessonService) {
        this.lessonService = lessonService;
    }

    @GetMapping("lesson/by")
    public ResponseEntity<?> showLessonExercises(
            @RequestParam(value = "lesson", required = false) Integer lessonId
    ) {
        if (lessonId != null) {
            return ResponseEntity.ok(lessonService.findLessonExercisesByLessonId(lessonId));
        }
        return ResponseEntity.ok(lessonService.findAllLessonExercises());
    }

    @GetMapping("lesson/user")
    public ResponseEntity<?> showLessonUsers(
            @RequestParam(value = "lesson", required = false) Integer lessonId
    ) {
        if (lessonId != null) {
            return ResponseEntity.ok(lessonService.findLessonUsersByLessonId(lessonId));
        }
        return ResponseEntity.ok(lessonService.findAllLessonUsers());
    }

}
