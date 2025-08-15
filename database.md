TABLE Member
- id
- name
- email
- phone
- birth_date
- membership_plan_id (FK)
- join_date
- expired_date

TABLE MembershipPlan
- id
- name (VIP / Standard)
- duration_months
- price

TABLE Payment
- id
- member_id (FK)
- amount
- method (Cash / BankTransfer)
- date

TABLE ClassSchedule
- id
- name (Yoga, Boxing...)
- start_time
- end_time
- trainer_name
- max_capacity

TABLE Registration (bảng trung gian)
- id
- member_id (FK)
- class_schedule_id (FK)
- registered_at

TABLE User
- id
- username
- password
- role (ADMIN / STAFF / MEMBER)
