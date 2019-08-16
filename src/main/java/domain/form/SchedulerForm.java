package domain.form;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Classname SchedulerForm
 * @Description TODO
 * @Date 2019/8/16 16:00
 * @Author lyn
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SchedulerForm {

    private String cron;
}
