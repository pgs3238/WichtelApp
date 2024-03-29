-- This file allow to write SQL commands that will be emitted in test and dev.
-- The commands are commented as their support depends of the database
-- insert into myentity (id, field) values(nextval('hibernate_sequence'), 'field-1');
-- insert into myentity (id, field) values(nextval('hibernate_sequence'), 'field-2');
-- insert into myentity (id, field) values(nextval('hibernate_sequence'), 'field-3');
INSERT INTO wichtel_user (email, name, password, vorname) VALUES ('danield@entenhausen.de', 'Duesentrieb', '$2a$10$JmYdquLaQO5ejpxsa9Fxg.NYuAcZz3f.YSEMdL6d6ZP27un3PSMJO', 'Daniel');
INSERT INTO user_roles (user_email, roles) VALUES ('danield@entenhausen.de', 'user');
-- passwort: 12345

INSERT INTO wichtel_user (email, name, password, vorname) VALUES ('doduck@entenhausen.de', 'Duck', '$2a$10$pWeBuWHLA6ilqQq4b3JXc.AU8QmsaxMsd6.svvmVv9oXzZd6fTry.', 'Donald');
INSERT INTO public.user_roles (user_email, roles) VALUES ('doduck@entenhausen.de', 'user');

--Testuser für Wichtel - passwort: string
INSERT INTO public.wichtel_user (email, name, password, vorname) VALUES ('string@1', 'string', '$2a$10$kKLh2n8AJFpIUbWKYjVIUeTyY.W8U2EQzqs63U1cTh7qIVRr4wcFq', 'string');
INSERT INTO public.wichtel_user (email, name, password, vorname) VALUES ('string@2', 'string', '$2a$10$XD1kx2CZKE8QHOdEfRgG2uONVyewyEPIA8ZU41/CqTugbM.ug7VqG', 'string');
INSERT INTO public.wichtel_user (email, name, password, vorname) VALUES ('string@3', 'string', '$2a$10$WmaNoqEH35KvMULHhUv.4O3E8zYjoAnJgZCL8dS5t7X7qUQTwyYzi', 'string');
INSERT INTO public.wichtel_user (email, name, password, vorname) VALUES ('string@4', 'string', '$2a$10$/eGjlYuPy/.CXHUymb//DujXZZ58qlE2Sa08YYDIlzEspfLJm9sP.', 'string');
INSERT INTO public.wichtel_user (email, name, password, vorname) VALUES ('string@5', 'string', '$2a$10$xQuKvfufSkTRFJzmbUuT..U9KfrHpKCM275hxd3KbAQQzESgkmLCe', 'string');
INSERT INTO public.wichtel_user (email, name, password, vorname) VALUES ('string@6', 'string', '$2a$10$EWy4rM4Mzn5KMsJo.vnaX.Yi93yNW9AMtURE7Rfor.FBwZ63lbZAe', 'string');
INSERT INTO public.wichtel_user (email, name, password, vorname) VALUES ('string@7', 'string', '$2a$10$Q1f.01IAK3jrdxYHMZA1W.n5KrcxbDwWP4uH6d11H1NSPv4lN68TO', 'string');
INSERT INTO public.wichtel_user (email, name, password, vorname) VALUES ('string@8', 'string', '$2a$10$FIE4zBcCMtKD.duGOyG60u3qYaGBti84gPY/SuyigyAwUoIeVQIJu', 'string');
INSERT INTO public.wichtel_user (email, name, password, vorname) VALUES ('string@9', 'string', '$2a$10$hKLgH5wkct0G3/wQoDXZpuOZzc4RdfTNfePt.vm8NRIJuOm/bLerm', 'string');
INSERT INTO public.wichtel_user (email, name, password, vorname) VALUES ('string@10', 'string', '$2a$10$YwYWWKZcxFlSkd39ja/YBOYBNRm7dU85UWX2HTNvOhaBhwCyRGXEC', 'string');
INSERT INTO public.user_roles (user_email, roles) VALUES ('string@1', 'user');
INSERT INTO public.user_roles (user_email, roles) VALUES ('string@2', 'user');
INSERT INTO public.user_roles (user_email, roles) VALUES ('string@3', 'user');
INSERT INTO public.user_roles (user_email, roles) VALUES ('string@4', 'user');
INSERT INTO public.user_roles (user_email, roles) VALUES ('string@5', 'user');
INSERT INTO public.user_roles (user_email, roles) VALUES ('string@6', 'user');
INSERT INTO public.user_roles (user_email, roles) VALUES ('string@7', 'user');
INSERT INTO public.user_roles (user_email, roles) VALUES ('string@8', 'user');
INSERT INTO public.user_roles (user_email, roles) VALUES ('string@9', 'user');
INSERT INTO public.user_roles (user_email, roles) VALUES ('string@10', 'user');


